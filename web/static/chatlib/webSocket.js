/**
 * Created by butioy on 2016/1/25.
 */
;!(function($, WebSocketClient, undefined) {
    'use strict';
    if( !WebSocketClient ) {
        WebSocketClient = window.WebSocketClient = {};
    }
    var s = {
        url:'',
        onOpen:null,
        onMessage:null,
        onClose:null,
        onError:null
    };
    WebSocketClient.ws = null;
    var webSocket = WebSocketClient;
    WebSocketClient.init = function( options ) {
        if( options ) {
            $.extend(true, s, options);
        }
        if( window.WebSocket ) {
            WebSocketClient.ws = new WebSocket("ws:"+s.url);
            this._bind(WebSocketClient.ws);
        } else {
            $.getScript("sock-client-1.0.3.js", function() {
                WebSocketClient.ws = new SockJS("http:"+s.url);
                webSocket._bind(WebSocketClient.ws);
            });
        }
        return webSocket.ws;
    };

    WebSocketClient._bind = function( ws ) {
        ws.onopen = function() {
            console.log("webSocket connected success");
            if(s.onOpen ) s.onOpen.call(this);
        };
        ws.onmessage = function(e) {
            console.log("webSocket push message!");
            if( s.onMessage ) s.onMessage.call(this, e);
        };
        ws.onclose = function(e) {
            console.log("webSocket closed success!");
            if( s.onClose ) s.onClose.call(this, e);
        };
        ws.onerror = function(e) {
            console.log("webSocket error!");
            if( s.onError ) s.onError.call(this, e);
        };
    };
    return WebSocketClient;
})(jQuery, window.WebSocketClient);