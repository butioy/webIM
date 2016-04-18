/*
 * jQuery jclock - Clock plugin - v 2.1.1
 * http://plugins.jquery.com/project/jclock
 *
 * Copyright (c) 2007-2009 Doug Sparling <http://www.dougsparling.com>
 * Licensed under the MIT License:
 *   http://www.opensource.org/licenses/mit-license.php
 */
(function($) {

  $.fn.jclock = function(options) {
    var version = '2.1.1';

    // options
    var opts = $.extend({}, $.fn.jclock.defaults, options);
         
    return this.each(function() {
      $this = $(this);
      $this.timerID = null;
      $this.running = false;

      var o = $.meta ? $.extend({}, opts, $this.data()) : opts;

      $this.format = o.format;
      $this.utc = o.utc;
      $this.utc_offset = o.utc_offset;

      $this.css({
        fontFamily: o.fontFamily,
        fontSize: o.fontSize,
        backgroundColor: o.background,
        color: o.foreground
      });

      // %a
      $this.daysAbbrvNames = new Array(7);
      $this.daysAbbrvNames[0]  = "周日";
      $this.daysAbbrvNames[1]  = "周一";
      $this.daysAbbrvNames[2]  = "周二";
      $this.daysAbbrvNames[3]  = "周三";
      $this.daysAbbrvNames[4]  = "周四";
      $this.daysAbbrvNames[5]  = "周五";
      $this.daysAbbrvNames[6]  = "周六";

      // %A
      $this.daysFullNames = new Array(7);
      $this.daysFullNames[0]  = "星期日";
      $this.daysFullNames[1]  = "星期一";
      $this.daysFullNames[2]  = "星期二";
      $this.daysFullNames[3]  = "星期三";
      $this.daysFullNames[4]  = "星期四";
      $this.daysFullNames[5]  = "星期五";
      $this.daysFullNames[6]  = "星期六";

      // %b
      $this.monthsAbbrvNames = new Array(12);
      $this.monthsAbbrvNames[0]  = "01";
      $this.monthsAbbrvNames[1]  = "02";
      $this.monthsAbbrvNames[2]  = "03";
      $this.monthsAbbrvNames[3]  = "04";
      $this.monthsAbbrvNames[4]  = "05";
      $this.monthsAbbrvNames[5]  = "06";
      $this.monthsAbbrvNames[6]  = "07";
      $this.monthsAbbrvNames[7]  = "08";
      $this.monthsAbbrvNames[8]  = "09";
      $this.monthsAbbrvNames[9]  = "10";
      $this.monthsAbbrvNames[10] = "11";
      $this.monthsAbbrvNames[11] = "12";

      // %B
      $this.monthsFullNames = new Array(12);
      $this.monthsFullNames[0]  = "一月";
      $this.monthsFullNames[1]  = "二月";
      $this.monthsFullNames[2]  = "三月";
      $this.monthsFullNames[3]  = "四月";
      $this.monthsFullNames[4]  = "五月";
      $this.monthsFullNames[5]  = "六月";
      $this.monthsFullNames[6]  = "七月";
      $this.monthsFullNames[7]  = "八月";
      $this.monthsFullNames[8]  = "九月";
      $this.monthsFullNames[9]  = "十月";
      $this.monthsFullNames[10] = "十一月";
      $this.monthsFullNames[11] = "十二月";

      $.fn.jclock.startClock($this);

    });
  };
       
  $.fn.jclock.startClock = function(el) {
    $.fn.jclock.stopClock(el);
    $.fn.jclock.displayTime(el);
  }

  $.fn.jclock.stopClock = function(el) {
    if(el.running) {
      clearTimeout(el.timerID);
    }
    el.running = false;
  }

  $.fn.jclock.displayTime = function(el) {
    var time = $.fn.jclock.getTime(el);
    el.html(time);
    el.timerID = setTimeout(function(){$.fn.jclock.displayTime(el)},1000);
  }

  $.fn.jclock.getTime = function(el) {
    var now = new Date();

    if(el.utc == true) {
      var localTime = now.getTime();
      var localOffset = now.getTimezoneOffset() * 60000;
      var utc = localTime + localOffset;
      var utcTime = utc + (3600000 * el.utc_offset);
      now = new Date(utcTime);
    }

    var timeNow = "";
    var i = 0;
    var index = 0;
    while ((index = el.format.indexOf("%", i)) != -1) {
      timeNow += el.format.substring(i, index);
      index++;

      // modifier flag
      //switch (el.format.charAt(index++)) {
      //}
      
      var property = $.fn.jclock.getProperty(now, el, el.format.charAt(index));
      index++;
      
      //switch (switchCase) {
      //}

      timeNow += property;
      i = index
    }

    timeNow += el.format.substring(i);
    return timeNow;
  };

  $.fn.jclock.getProperty = function(dateObject, el, property) {

    switch (property) {
      case "a": // abbrv day names
          return (el.daysAbbrvNames[dateObject.getDay()]);
      case "A": // full day names
          return (el.daysFullNames[dateObject.getDay()]);
      case "b": // abbrv month names
          return (el.monthsAbbrvNames[dateObject.getMonth()]);
      case "B": // full month names
          return (el.monthsFullNames[dateObject.getMonth()]);
      case "d": // day 01-31
          return ((dateObject.getDate() <  10) ? "0" : "") + dateObject.getDate();
      case "H": // hour as a decimal number using a 24-hour clock (range 00 to 23)
          return ((dateObject.getHours() <  10) ? "0" : "") + dateObject.getHours();
      case "I": // hour as a decimal number using a 12-hour clock (range 01 to 12)
          var hours = (dateObject.getHours() % 12 || 12);
          return ((hours <  10) ? "0" : "") + hours;
      case "M": // minute as a decimal number
          return ((dateObject.getMinutes() <  10) ? "0" : "") + dateObject.getMinutes();
      case "p": // either `am' or `pm' according to the given time value,
		// or the corresponding strings for the current locale
          return (dateObject.getHours() < 12 ? "上午" : "下午");
      case "S": // second as a decimal number
          return ((dateObject.getSeconds() <  10) ? "0" : "") + dateObject.getSeconds();
      case "y": // two-digit year
          return ""; // TODO
      case "Y": // full year
        return (dateObject.getFullYear());
      case "%":
          return "%";
    }

  }
       
  // plugin defaults (24-hour)
  $.fn.jclock.defaults = {
    format: '%H:%M:%S', 
    utc_offset: 0,
    utc: false,
    fontFamily: '',
    fontSize: '',
    foreground: '',
    background: ''
  };

})(jQuery);
