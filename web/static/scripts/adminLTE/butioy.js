/*! AdminLTE butioy.js
 * ================
 * Main JS application file for AdminLTE v2. This file
 * should be included in all pages. It controls some layout
 * options and implements exclusive AdminLTE plugins.
 *
 * @Author  Almsaeed Studio
 * @Support <http://www.almsaeedstudio.com>
 * @Email   <support@almsaeedstudio.com>
 * @version 2.3.0
 * @license MIT <http://opensource.org/licenses/MIT>
 */

//Make sure jQuery has been loaded before app.js
if (typeof jQuery === "undefined") {
  throw new Error("butioy requires jQuery");
}

if (typeof layer === "undefined") {
  throw new Error("butioy requires layer");
}

/**
 * 工具类模块
 */
;(function($, u) {
  if( !u )
  u = window.util = {};
  $.extend(true, u, {
    getTopWin : function() {
      var currWin = window;
      while( currWin != currWin.parent ) {
        currWin = currWin.parent;
      }
      return currWin;
    }
  });
}(jQuery, window.util));

/* ------------------
 * - Implementation -
 * ------------------
 * The next block of code implements AdminLTE's
 * functions and plugins as specified by the
 * options above.
 */
;(function ($, butioy) {
  "use strict";
  if( !butioy ) {
    butioy = window.butioy = {};
  }
  var setting = {
    defaultSkin : "layui-layer-lan"
  };
  $.extend(true, butioy, {
    success:function( message, time, callback ) {
      var topW = util.getTopWin();
      topW.layer.alert(message, {skin:setting.defaultSkin, icon:6}, function() {
        if( typeof callback === "function" ) {
          callback.call(this);
        }
      });
    },
    fail : function() {

    },
    open : function( option ) {
      var s = {
        url : '',
        title : '提示框'
      };
      $.extend(true, s, options);
      util.getTopWin().layer.open({
        type: 2,
        skin: setting.defaultSkin,
        title: s.title,
        fix: true,
        moveType: 1,
        shade: 0.8,
        shadeClose: false,
        area:"50%",
        content: s.url
      });
    }
  });

}(jQuery, window.butioy));