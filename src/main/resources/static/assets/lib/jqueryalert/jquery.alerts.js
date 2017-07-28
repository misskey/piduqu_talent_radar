// jQuery Alert Dialogs Plugin
//
// Version 1.1
//
// Cory S.N. LaViska
// A Beautiful Site (http://abeautifulsite.net/)
// 14 May 2009
//
// Website: http://abeautifulsite.net/blog/2008/12/jquery-alert-dialogs/
//
// Usage:
//		jAlert( message, [title, callback] )
//		jConfirm( message, [title, callback] )
//		jPrompt( message, [value, title, callback] )
// 
// History:
//
//		1.00 - Released (29 December 2008)
//
//		1.01 - Fixed bug where unbinding would destroy all resize events
//
// License:
// 
// This plugin is dual-licensed under the GNU General Public License and the MIT License and
// is copyright 2008 A Beautiful Site, LLC. 
//
(function($) {
	
	$.alerts = {
		
		// These properties can be read/written by accessing $.alerts.propertyName from your scripts at any time
		
		verticalOffset: -75,                // vertical offset of the dialog from center screen, in pixels
		horizontalOffset: 0,                // horizontal offset of the dialog from center screen, in pixels/
		repositionOnResize: true,           // re-centers the dialog on window resize
		overlayOpacity: .3,                // transparency level of overlay
		overlayColor: '#BCBCBC',               // base color of overlay
		draggable: true,                    // make the dialogs draggable (requires UI Draggables plugin)
		okButton: '&nbsp;确定&nbsp;',         // text for the OK button
		cancelButton: '&nbsp;取消&nbsp;', // text for the Cancel button
		dialogClass: null,                  // if specified, this class will be applied to all dialogs
		screenIframe : $("<iframe class='ui-draggable' frameborder='no' border='0'></iframe>"),
		
		// Public methods
		
		alert: function(message,  callback,icon ,showIframe) {
			icon = icon == undefined ? "../script/lib/jqueryalert/images/alert.gif" :icon;
			$.alerts._show( message, null, 'alert', function(result) {
				if( callback ) callback(result);
			},icon, showIframe);
		},
		
		confirm: function(message,callback,icon, showIframe) {
			icon = icon == undefined ? "../script/lib/jqueryalert/images/alert.gif" :icon;
			$.alerts._show( message, null, 'confirm', function(result) {
				if( callback ) callback(result);
			},icon , showIframe);
		},
			
		prompt: function(message, value, title, callback, icon,showIframe) {
			$.alerts._show( message, value, 'prompt', function(result) {
				if( callback ) callback(result);
			},icon,showIframe);
		},
		
		tip: function(message, time, callback,icon, showIframe) {
			icon = icon == undefined ? "../script/lib/jqueryalert/images/alert.gif" :icon;
			time = time == undefined ? 1000 : time;
			$.alerts._show( message, null, 'tip', function(result) {
				if( callback ) callback(result);
			},icon,showIframe);
			window.setTimeout(function(){
				$.alerts._hide();
			}, time);
		},
		// Private methods
		
		_show: function( msg, value, type, callback,icon, showIframe) {
			
			$.alerts._hide();
			$.alerts._overlay('show');
			
			$("BODY").append(
			  '<div id="popup_container">' +
			    '<h1 id="popup_title"></h1>' +
			    '<div id="popup_content">' +
			      '<div id="popup_message"><img src="'+icon+'"><div id="popup_messageText"></div></div>' +
				'</div>' +
			  '</div>');
			
			if( $.alerts.dialogClass ) $("#popup_container").addClass($.alerts.dialogClass);
			
			// IE6 Fix
			var pos =  ('undefined' == typeof(document.body.style.maxHeight)) ? 'absolute' : 'fixed';
			
			$("#popup_container").css({
				position: pos,
				zIndex: 99999,
				padding: 0,
				margin: 0
			});
			
			//$("#popup_title").text(title);
			$("#popup_content").addClass(type);
			$("#popup_messageText").text(msg);
			$("#popup_messageText").html( $("#popup_message").text().replace(/\n/g, '<br />') );
			
			$.alerts._reposition();
			$.alerts._maintainPosition(true);
			
			switch( type ) {
				case 'alert':
					$("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /></div>');
					$("#popup_ok").click( function() {
						$.alerts._hide();
						callback(true);
					});
					$("#popup_ok").keypress( function(e) {
						if( e.keyCode == 13 || e.keyCode == 27 ) $("#popup_ok").trigger('click');
					});
					window.setTimeout(function(){$("#popup_ok").focus();}, 10);
				break;
				case 'confirm':
					$("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /> </div>');
					$("#popup_ok").click( function() {
						$.alerts._hide();
						if( callback ) callback(true);
					});
					$("#popup_cancel").click( function() {
						$.alerts._hide();
						if( callback ) callback(false);
					});
					$("#popup_ok").focus();
					$("#popup_ok, #popup_cancel").keypress( function(e) {
						if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
						if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
					});
				break;
				case 'prompt':
					$("#popup_message").append('<br /><input type="text" size="30" id="popup_prompt" />').after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /> <input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
					$("#popup_prompt").width( $("#popup_message").width() );
					$("#popup_ok").click( function() {
						var val = $("#popup_prompt").val();
						$.alerts._hide();
						if( callback ) callback( val );
					});
					$("#popup_cancel").click( function() {
						$.alerts._hide();
						if( callback ) callback( null );
					});
					$("#popup_prompt, #popup_ok, #popup_cancel").keypress( function(e) {
						if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
						if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
					});
					if( value ) $("#popup_prompt").val(value);
					$("#popup_prompt").focus().select();
				break;
				case 'tip':
					$("#popup_message").after('<div id="popup_panel"></div>');
				break;
			}
			
			//edit by sunhailin 2013-10-12 start
			/*if(showIframe && false){
				$.alerts._showIframe(true);
				$.alerts.draggable = false;
				$.alerts._maintainPosition(false);
			}*/
			//edit by sunhailin 2013-10-12 start
			// Make draggable
			if( $.alerts.draggable ) {
				try {
					$("#popup_container").draggable({ handle: $("#popup_title") });
					$("#popup_title").css({ cursor: 'move' });
				} catch(e) { /* requires jQuery UI draggables */ }
			}
		},
		
		_hide: function() {
			$.alerts._hideIframe();
			$("#popup_container").remove();
			$.alerts._overlay('hide');
			$.alerts._maintainPosition(false);
		},
		
		_overlay: function(status) {
			switch( status ) {
				case 'show':
					$.alerts._overlay('hide');
					$("BODY").append('<div id="popup_overlay"></div>');
					/*
					$("BODY").append('<div id="popup_overlay"><iframe width="100%" height="100%" frameborder="0"></iframe><div></div></div>');
					$("#popup_overlay").css({
						background: $.alerts.overlayColor,
						opacity: $.alerts.overlayOpacity
					});
					*/
				break;
				case 'hide':
					$("#popup_overlay").remove();
				break;
			}
		},
		
		_reposition: function() {
			var top = (($(window).height() / 2) - ($("#popup_container").outerHeight() / 2)) + $.alerts.verticalOffset;
			var left = (($(window).width() / 2) - ($("#popup_container").outerWidth() / 2)) + $.alerts.horizontalOffset;
			if( top < 0 ) top = 0;
			if( left < 0 ) left = 0;
			
			// IE6 fix
			if ('undefined' == typeof(document.body.style.maxHeight)) top = top + $(window).scrollTop();
			
			$("#popup_container").css({
				top: top + 'px',
				left: left + 'px'
			});
			$("#popup_overlay").height( $(document).height() );
		},
		
		_maintainPosition: function(status) {
			if( $.alerts.repositionOnResize ) {
				switch(status) {
					case true:
						$(window).bind('resize', $.alerts._reposition);
					break;
					case false:
						$(window).unbind('resize', $.alerts._reposition);
					break;
				}
			}
		},
		_showIframe:function(status){
			/*if(status){
				$($.alerts.screenIframe).insertBefore($("#popup_container"));
				$($.alerts.screenIframe).attr("style",$("#popup_container").attr("style"));
				$($.alerts.screenIframe).css({
					minWidth: $("#popup_container").outerWidth(),
					maxWidth: $("#popup_container").outerWidth()
				});
				$.alerts.screenIframe.css({
					"height": $("#popup_container").height()
				});
			}*/
		},
		_hideIframe:function(){
			/*$($.alerts.screenIframe).remove();*/
		}
	};
	
	// Shortuct functions
	jAlert = function(message,callback, icon, showIframe) {
		$.alerts.alert(message,  callback,icon, showIframe);
	};
	
	jConfirm = function(message, callback, icon, showIframe) {
		$.alerts.confirm(message,  callback, showIframe);
	};
		
	jPrompt = function(message, callback,icon,  showIframe) {
		$.alerts.prompt(message,  callback, showIframe);
	};
	
	jTip = function(message, time, callback, icon, showIframe) {
		$.alerts.tip(message, time, callback, icon, showIframe);
	};
})(jQuery);