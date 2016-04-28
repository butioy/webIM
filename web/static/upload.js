/**
 * Created by butioy on 2016/4/28.
 */
'use strict';
(function(_w) {
    var BU = _w.BU = {};
    var settings = {
        url : '/upload/doUpload',
        fileId : 'file_input',
        selectId : 'selectBtn',
        selectText : '选择文件',
        uploadId : 'uploadBtn',
        uploadText : '上传文件',
        previewId : 'preview',
        repeat : false,
        multi : false,
        paramName : 'file',
        accepts : '*',
        selected : function(file, index, allFiles){},
        uploadSuccess : function(file, index, allFiles, resp) {},
        uploadComplete : function(allFiles, resp) {},
        uploadError : function(file, index, allFiles, resp) {},
        uploadFail : function(file, index, allFiles, resp) {}
    };
    var _bu = BU,
        input,
        selectBtn,
        uploadBtn,
        allFiles=[],
        fileNames=[];
    BU.browser = (function( ua ) {
        var ret = {},
            webkit = ua.match(/WebKit\/([\d.]+)/),
            chrome = ua.match(/Chrome\/([\d.]+)/) || ua.match(/CriOS\/([\d.]+)/),
            ie = ua.match(/MSIE\s([\d\.]+)/) || ua.match(/(?:trident)(?:.*rv:([\w.]+))?/i),
            firefox = ua.match(/Firefox\/([\d.]+)/),
            safari = ua.match(/Safari\/([\d.]+)/),
            opera = ua.match(/OPR\/([\d.]+)/);
        webkit && (ret.webkit = parseFloat(webkit[1]));
        chrome && (ret.chrome = parseFloat(chrome[1]));
        ie && (ret.ie = parseFloat(ie[1]));
        firefox && (ret.firefox = parseFloat(firefox[1]));
        safari && (ret.safari = parseFloat(safari[1]));
        opera && (ret.opera = parseFloat(opera[1]));
        return ret;
    })(navigator.userAgent);

    BU.os = (function(ua) {
        var ret = {},
            android = ua.match(/(?:Android);?[\s\/]+([\d.]+)?/),
            ios = ua.match(/(?:iPad|iPod|iPhone).*OS\s([\d_]+)/);
        android && (ret.android = parseFloat(android[1]));
        ios && (ret.ios= parseFloat(ios[1].replace(/_/g,'.')));
        return ret;
    })(navigator.userAgent);

    BU.create = function() {
        input = document.getElementById(settings.fileId);
        input.style.display = 'block';
        if( !_bu.os.android && !_bu.os.ios ) {
            var accepts = settings.accepts;
            if( accepts.indexOf('*') === -1 ) {
                var tmp = accepts.split('|').map(function(x) {return '.'+x});
                accepts = tmp.join(',');
            }
            input.setAttribute('accept', accepts);
            input.setAttribute('multiple', '');
        }
        selectBtn = document.getElementById(settings.selectId);
        uploadBtn = document.getElementById(settings.uploadId);
        selectBtn.addEventListener('click', function(e) {
            input.click();
            e.preventDefault();
        });
        input.addEventListener('change',function(e) {
            e.preventDefault();
            var files = input.files;
            var len = allFiles.length;
            for( var i=0; i<files.length; i++ ) {
                var file = files[i];
                if(settings.repeat){
                    allFiles.push(file);
                } else {
                    var flag = fileNames.indexOf(file.name)<0;
                    if( flag ) {
                        allFiles.push(file);
                        fileNames.push(file.name);
                    }
                }
                settings.selected.apply(null, [file, len+i, allFiles]);
            }
        });
        uploadBtn.addEventListener('click', function() {
            allFiles.map(function( file, index, arr ) {
                _bu.uploadProcess(file, index);
            });
        });
    };

    BU.uploadProcess = function(file, index) {
        var xhr = _bu.getXhr();
        var formData = new FormData();
        formData.append(settings.paramName, file);
        xhr.onreadystatechange = function() {
            if( xhr.readyState === 4 ) {
                if( xhr.status === 200 ) {
                    settings.uploadSuccess.apply(null, [file, index, allFiles, xhr.responseText]);
                } else {
                    settings.uploadFail.apply(null, [file, index, allFiles, xhr.responseText]);
                }
            }
        };
        xhr.onerror = function() {
            settings.uploadError(file, index, allFiles, '');
        };
        xhr.onprogress = function() {
            document.getElementById('progress').value = 10;

        }
        xhr.open('POST', settings.url);
        xhr.send(formData);
    };

    BU.getXhr = function() {
        if( _w.XMLHttpRequest ) {
            return new XMLHttpRequest();
        } else {
            return new ActiveXObject('Microsoft.XMLHTTP');
        }
    };

    BU.init = function( option ) {
        settings.url = option.url || settings.url;
        settings.fileId = option.fileId || settings.fileId;
        settings.selectId = option.selectId || settings.selectId;
        settings.selectText = option.selectText || settings.selectText;
        settings.uploadId = option.uploadId || settings.uploadId;
        settings.uploadText = option.uploadText || settings.uploadText;
        settings.previewId = option.previewId || settings.previewId;
        settings.repeat = option.repeat || settings.repeat;
        settings.multi = option.multi || settings.multi;
        settings.accepts = option.accepts || settings.accepts;
        settings.paramName = option.paramName || settings.paramName;
        settings.selected = option.selected || settings.selected;
        settings.uploadSuccess = option.uploadSuccess || settings.uploadSuccess;
        settings.uploadComplete = option.uploadComplete || settings.uploadComplete;
        settings.uploadError = option.uploadError || settings.uploadError;
        settings.uploadFail = option.uploadFail || settings.uploadFail;
        _bu.create();
    };
    return _bu;
})(window);