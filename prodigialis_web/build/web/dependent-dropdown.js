(function($) {
    $(document).ready(function() {
        var parents = {};
        
        var srcSelect = 'edit-loc'; // id of the select containing the original, flat list of options
        // Any option having this character(s) at least once will be considered child
        // It is assumed this "magic" word is found before the part of the option that
        // must be preserved when put into the level2 select
        var childChar = '/'; 
        var level1Label = '- ANY CITY -'; // "all" values text for level 1 select
        var level2Label = '- ANY AREA -'; // "all" values text for level 2 select
        var level1Id = 'city'; // Id to use for the level1 select
        var level2Id = 'area'; // Id to use for the level2 select
        var allOptionValue = 'All'; // value of the "all" option in the srcSelect
        
        // Returns true if the text of the option has the childChar
        function isChildItem(opt) {
            var optText = $(opt).attr('text');
            return optText.indexOf(childChar) == -1 ? false: true;
        }
        
        // Stores the latest parent found
        var curParentVal = null;
        // Clones an option to the appropriate select in the hierarchy
        function addOption(parent, child, opt) {
            var optVal = $(opt).attr('value');
            var optText = $(opt).attr('text');
            var childCharPos = optText.indexOf(childChar);
            var cloneOpt = $(opt).clone();
            if (! isChildItem(opt)) {
                $('#' + parent).append(cloneOpt);
                curParentVal = optVal;
            } else {
                var childOptText = optText.slice(childCharPos+1);
                // Prepares the clone before appending it
                $(cloneOpt)
                    .addClass("sub_"+curParentVal)
                    .attr('text', childOptText);
                $('#' + child).append(cloneOpt);
                // Stores the child:parent relationship in the parents object
                parents[optVal] = curParentVal;
            }
        }
        
        // Turns on the selected attribute on the option whose value is optValue
        function markOptionSelected(selectId, optValue) {
            return $('#'+selectId+' option[value="'+optValue+'"]')
                .attr('selected', 'selected');
        }
        
        // Clone only the .sub_X options from hidden select, X being current parent's value
        // and use it as new set of options for the child select
        function refreshChildOptions(parent, child, isSubselectOptional) {
            var parentValue = $('#'+parent).attr('value');
            $('#' + child).html($("#" + parent + child + " .sub_" + parentValue).clone());
            if (isSubselectOptional) {
                $('#' + child)
                    .prepend("<option value='"+parentValue+"'>"+level2Label+"</option>");
            }
        }
        
        // Generate City - Area separated selects from original one. Initially hide them.
        $("#"+srcSelect+"-wrapper .form-item")
            .append("<select id='"+level1Id+"' class='form-select' style='display: none;'></select>")
            .append("<select id='"+level2Id+"' class='form-select' style='display: none;'></select>");
        
        // Iterate over the original options to add them to the dependant dropdowns
        $("#"+srcSelect+" option").each(function(index, item) {
            var optVal = $(item).attr('value');
            if (optVal != allOptionValue) {
                addOption(level1Id, level2Id, item);
            }
        });
        // Add the "all" option to the level1 select, do cloning just for convenience
        allOpt = $('#'+srcSelect+' option:first')
            .clone()
            .attr('text', level1Label);
        $("#"+level1Id).prepend(allOpt);
        
        // Ensure proper initialization of dependant dropdowns
        var initValue = $('#'+srcSelect).attr('value');
        var parentValue = parents[initValue];
        if (typeof parentValue == "undefined") {
            markOptionSelected(level1Id, initValue);
        } else {
            markOptionSelected(level1Id, parentValue);
            markOptionSelected(level2Id, initValue);
        }
    
        // Original taken from: http://www.ajaxray.com/Examples/depend.html
        // Edits:
        // 19-Jan-2012: John Herreño (jedihe<a.t>gmail.com)
        function makeSublist(parent, child, isSubselectOptional, childVal) {
            // Add a hidden select to store the full possibilities for child, without filtering from parent's current value
            $("#"+srcSelect+"-wrapper .form-item").append("<select style='display:none' id='" + parent + child + "'></select>");
            // Get all the options from child and put them in hidden select
            $('#' + parent + child).html($("#" + child + " option"));
    
            // Read current parent's value
            var parentValue = $('#' + parent).attr('value');
            refreshChildOptions(parent, child, isSubselectOptional);
            
            // Select the default child option
            childVal = (typeof childVal == "undefined") ? "" : childVal;
            markOptionSelected(child, childVal);
    
            // Bind to change event on parent select
            $('#' + parent).change(function() {
                var parentValue = $('#' + parent).attr('value');
                $('#'+srcSelect).attr('value', parentValue);
                refreshChildOptions(parent, child, isSubselectOptional);
                if (parentValue != allOptionValue) {
                    $('#' + child).focus();
                }
            });
            // Bind to change event on child select
            $('#' + child).change(function() {
                var childValue = $('#' + child).attr('value');
                $('#'+srcSelect).attr('value', childValue);
            });
        }

        makeSublist(level1Id, level2Id, true);
        
        // Fix "sticky" child when initialization causes a child item to be the default one
        $('#'+level1Id+level2Id+' option:selected').removeAttr('selected');
        markOptionSelected(level1Id+level2Id, allOptionValue);
        
        $('#'+srcSelect).hide(); // Comment to see the original select being driven by the new ones
        $('#'+level1Id).show(); // Only show the new selects at the very end, when we're sure it's all been set up correctly
        $('#'+level2Id).show();
    });
})(jQuery);