parcelRequire=function(e,r,t,n){var i,o="function"==typeof parcelRequire&&parcelRequire,u="function"==typeof require&&require;function f(t,n){if(!r[t]){if(!e[t]){var i="function"==typeof parcelRequire&&parcelRequire;if(!n&&i)return i(t,!0);if(o)return o(t,!0);if(u&&"string"==typeof t)return u(t);var c=new Error("Cannot find module '"+t+"'");throw c.code="MODULE_NOT_FOUND",c}p.resolve=function(r){return e[t][1][r]||r},p.cache={};var l=r[t]=new f.Module(t);e[t][0].call(l.exports,p,l,l.exports,this)}return r[t].exports;function p(e){return f(p.resolve(e))}}f.isParcelRequire=!0,f.Module=function(e){this.id=e,this.bundle=f,this.exports={}},f.modules=e,f.cache=r,f.parent=o,f.register=function(r,t){e[r]=[function(e,r){r.exports=t},{}]};for(var c=0;c<t.length;c++)try{f(t[c])}catch(e){i||(i=e)}if(t.length){var l=f(t[t.length-1]);"object"==typeof exports&&"undefined"!=typeof module?module.exports=l:"function"==typeof define&&define.amd?define(function(){return l}):n&&(this[n]=l)}if(parcelRequire=f,i)throw i;return f}({"c1WM":[function(require,module,exports) {
"use strict";function e(e,t,r){e.addEventListener(t,function(e){return r(e)})}Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=void 0;var t={on:e};exports.default=t;
},{}],"kuUU":[function(require,module,exports) {
"use strict";function t(t,e){fetch(t).then(function(t){return t.json()}).then(function(t){return e(t)}).catch(function(t){return console.log(t)})}function e(t,e,n){fetch(t,{method:"POST",body:JSON.stringify(e)}).then(function(t){return t.json()}).then(function(t){return n(t)}).catch(function(t){return console.log(t)})}Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=void 0;var n={getRequest:t,postRequest:e};exports.default=n;
},{}],"bss0":[function(require,module,exports) {
"use strict";Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=void 0;var n=e(require("./add"));function e(n){return n&&n.__esModule?n:{default:n}}function t(n){return'\n    <div>\n        <ul class="songs">\n        '.concat(n.map(function(n){return'\n                            <li class="song">\n                                <h5 class="song__title clickable">'.concat(n.title,"</h5>                       \n                            </li>\n                        ")}).join(""),"\n        </ul>\n    </div>  \n        ")}function r(e){return"\n    ".concat(t(e),'\n    <div class="user-input">\n        ').concat(n.default.addSong(),"\n    </div>   \n        ")}function s(n){return'\n        <h4 class="song__header">Songs</h4>\n        '.concat(this.renderSongs(n),"\n    ")}function o(e){return'\n        <h2 class="song__title">'.concat(e.title,'</h2>  \n        <div class="user-input">\n        ').concat(n.default.addRatingAndComment(),"    \n        </div>               \n    ")}var c={renderSongsAdd:r,renderSongs:t,renderSong:o,renderSongsHeader:s};exports.default=c;
},{"./add":"e6ox"}],"a9Z7":[function(require,module,exports) {
"use strict";Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=void 0;var n=t(require("./Songs")),e=t(require("./add"));function t(n){return n&&n.__esModule?n:{default:n}}function l(n){return'\n    <div>\n    <ul class="albums">\n    '.concat(n.map(function(n){return'\n                        <li class="album">\n                            <h5 class="album__title clickable">'.concat(n.title,"</h5>                       \n                        </li>\n                    ")}).join(""),"\n        </ul>\n        </div>\n        ")}function u(n){return"\n        ".concat(l(n),'\n        <div class="user-input">\n        ').concat(e.default.addAlbum(),"\n    </div>\n        ")}function r(e){return'\n    <div>\n    <ul class="albums">\n    '.concat(e.map(function(e){return'\n                <li class="album">\n                    <h5 class="album__title clickable" value='.concat(e.id,">").concat(e.title,"</h5>  \n                        ").concat(n.default.renderSongs(e.songs),"             \n                </li>\n            ")}).join(""),"\n    </ul>\n    </div>\n    ")}function a(n){return'\n        <h4 class="Album__header">Albums</h4>\n        '.concat(this.renderAlbumsAndSongs(n),"\n    ")}function s(e){return'\n        <h2 class="album__title">'.concat(e.title,"</h2>  \n            ").concat(n.default.renderSongsHeader(e.songs),"             \n    ")}var c={renderAlbums:l,renderAlbumsAdd:u,renderAlbumsAndSongs:r,renderAlbumAndSongs:s,renderAlbumsHeaderAndSongs:a};exports.default=c;
},{"./Songs":"bss0","./add":"e6ox"}],"1QnD":[function(require,module,exports) {
"use strict";Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=n;var e=t(require("../Utils/API/api-actions"));function t(e){return e&&e.__esModule?e:{default:e}}function n(e){return e.map(function(e){return"   \n            <option value=".concat(e.id,">").concat(e.name,"</option>    \n            ")}).join("")}
},{"../Utils/API/api-actions":"kuUU"}],"mzOq":[function(require,module,exports) {
"use strict";Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=n;var t=e(require("../Utils/API/api-actions"));function e(t){return t&&t.__esModule?t:{default:t}}function n(t){return t.map(function(t){return"   \n        <option value=".concat(t.id,">").concat(t.title,"</option>    \n        ")}).join("")}
},{"../Utils/API/api-actions":"kuUU"}],"e6ox":[function(require,module,exports) {
"use strict";Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=void 0;var t=o(require("../Utils/Events/event-actions")),e=o(require("./Artists.js")),n=o(require("./Albums.js")),a=o(require("./Songs.js")),s=o(require("./artist.js")),l=o(require("./album.js")),d=o(require("../Utils/API/api-actions"));function o(t){return t&&t.__esModule?t:{default:t}}function i(){return'\n    <section class="add__artist">\n        <h3>Add Artist</h3>\n        \n            <input type="select" class="add__artist--name" placeholder="artist name">\n            <input type="text" class="add__artist--image" placeholder="image">\n            <button class="add__artist--submit clickable">Add Artist</button>\n        </section> \n        '}function c(){return d.default.getRequest("/artists",function(t){document.querySelector(".add__album--artist").innerHTML=(0,s.default)(t)}),'\n    <section class="add__album">\n        <h3>Add Album</h3>\n        \n            <select type="select" class="add__album--artist" placeholder="Pick Artist">\n            \n            </select>                 \n            <input type="text" class="add__album--title" placeholder="title">\n            <input type="text" class="add__album--image" placeholder="image">\n            <input type="text" class="add__album--recordLabel" placeholder="recordLabel">\n            <button class="add__album--submit clickable">Add Album</button>\n        </section>\n        '}function u(){return d.default.getRequest("/albums",function(t){document.querySelector(".add__song--album").innerHTML=(0,l.default)(t)}),'\n    <section class="add__song">\n        <h3>Add Song</h3>\n        \n            <select type="select" class="add__song--album" placeholder="Pick Album">\n            </select>\n            <input type="text" class="add__song--title" placeholder="title">\n            <input type="text" class="add__song--link" placeholder="link">\n            <input type="text" class="add__song--duration" placeholder="duration">\n            <button class="add__song--submit clickable">Add Song</button>\n        </section>\n        '}function r(){return'\n    <section class="add__rating__comment">\n        <h3>Add Rating and Comment</h3>\n        <select type="select" class="add__rating" placeholder="Choose Rating">\n            <option value=1>1</option> \n            <option value=2>2</option>\n            <option value=3>3</option>\n            <option value=4>4</option>\n            <option value=5>5</option> \n        </select>\n        <input type="text" class="add__comment--content" placeholder="comment">\n        <button class="add__comment--submit clickable">Add Comment</button>\n    </section> \n        '}var _={addArtist:i,addAlbum:c,addSong:u,addRatingAndComment:r};exports.default=_;
},{"../Utils/Events/event-actions":"c1WM","./Artists.js":"NbHq","./Albums.js":"a9Z7","./Songs.js":"bss0","./artist.js":"1QnD","./album.js":"mzOq","../Utils/API/api-actions":"kuUU"}],"NbHq":[function(require,module,exports) {
"use strict";Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=void 0;var n=e(require("./add")),t=e(require("./Songs")),a=e(require("./Albums"));function e(n){return n&&n.__esModule?n:{default:n}}function s(t){return'\n    <div>\n        <ul class="artists">\n            '.concat(t.map(function(n){return'\n                    <li class="artist">\n                        <h5 class="artist__name clickable">'.concat(n.name,"</h5>  \n                            ").concat(a.default.renderAlbumsAndSongs(n.albums),"                      \n                    </li>\n                ")}).join(""),'\n        </ul>\n    </div>\n    <div class="user-input">\n        ').concat(n.default.addArtist(),"\n        ").concat(n.default.addAlbum(),"\n        ").concat(n.default.addSong(),"\n    </div>\n    ")}function r(t){return'\n    <div>\n        <ul class="artists">\n            '.concat(t.map(function(n){return'\n                    <li class="artist">\n                        <h5 class="artist__name clickable">'.concat(n.name,"</h5>  \n                                                \n                    </li>\n                ")}).join(""),'\n        </ul>\n    </div>\n    <div class="user-input">\n        ').concat(n.default.addArtist(),"\n    </div>\n    ")}function u(n){return'\n        <h2 class="artist__name">'.concat(n.name,"</h2>  \n            ").concat(a.default.renderAlbumsHeaderAndSongs(n.albums),"                  \n    ")}var c={renderArtists:r,renderArtistsAndAlbumsAndSongs:s,renderArtistAndAlbumsAndSongs:u};exports.default=c;
},{"./add":"e6ox","./Songs":"bss0","./Albums":"a9Z7"}],"2KtP":[function(require,module,exports) {
"use strict";function l(){return'\n        <figure class="figure-logo">\n            <img class = "logo clickable" src="/html/img/logo.png" alt="logo">\n        </figure>\n        <h1>Down with the Hipsters!!!!</h1>\n        <nav class="header-nav">\n            <ul class="nav-list">\n                <li class="nav-artist clickable">Artist</li>\n                <li class="nav-album clickable">Album</li>\n                <li class="nav-song clickable">Song</li>\n            </ul>\n        <nav>\n        '}Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=l;
},{}],"GFX4":[function(require,module,exports) {
"use strict";var e=r(require("./Utils/Events/event-actions")),t=r(require("./Utils/API/api-actions")),n=r(require("./Components/Artists")),a=r(require("./Components/Albums")),s=r(require("./Components/Songs")),u=r(require("./Components/header"));function r(e){return e&&e.__esModule?e:{default:e}}function i(){l().innerHTML=(0,u.default)(),e.default.on(l(),"click",function(){event.target.classList.contains("logo")&&t.default.getRequest("/artists",function(e){d().innerHTML=n.default.renderArtistsAndAlbumsAndSongs(e)}),event.target.classList.contains("nav-artist")&&t.default.getRequest("/artists",function(e){d().innerHTML=n.default.renderArtists(e)}),event.target.classList.contains("nav-album")&&t.default.getRequest("/albums",function(e){d().innerHTML=a.default.renderAlbumsAdd(e)}),event.target.classList.contains("nav-song")&&t.default.getRequest("/songs",function(e){d().innerHTML=s.default.renderSongsAdd(e)})})}function o(){t.default.getRequest("/artists",function(e){d().innerHTML=n.default.renderArtistsAndAlbumsAndSongs(e)}),e.default.on(d(),"click",function(){if(event.target.classList.contains("artist__name")){var e,u=event.target.parentElement.querySelector(".artist__name").textContent;t.default.postRequest("/artists/nameToId",{artistName:u},function(a){e=a,t.default.getRequest("/artists/"+e,function(e){d().innerHTML=n.default.renderArtistAndAlbumsAndSongs(e)})})}if(event.target.classList.contains("album__title")){var r,i=event.target.parentElement.querySelector(".album__title").textContent;t.default.postRequest("/albums/nameToId",{albumTitle:i},function(e){r=e,t.default.getRequest("/albums/"+r,function(e){d().innerHTML=a.default.renderAlbumAndSongs(e)})})}if(event.target.classList.contains("song__title")){var o,l=event.target.parentElement.querySelector(".song__title").textContent;t.default.postRequest("/songs/nameToId",{songTitle:l},function(e){o=e,t.default.getRequest("/songs/"+o,function(e){d().innerHTML=s.default.renderSong(e)})})}if(event.target.classList.contains("add__artist--submit")){var c=document.querySelector(".add__artist--name").value,m=document.querySelector(".add__artist--image").value;t.default.postRequest("/artists/addArtist",{name:c,image:m},function(e){console.log(e),d().innerHTML=n.default.renderArtistsAndAlbumsAndSongs(e)})}if(event.target.classList.contains("add__album--submit")){var f=document.querySelector(".add__album--artist").value,g=document.querySelector(".add__album--title").value,_=document.querySelector(".add__album--image").value,q=document.querySelector(".add__album--recordLabel").value;t.default.postRequest("/albums/addAlbum",{artist:f,title:g,image:_,recordLabel:q},function(e){d().innerHTML=n.default.renderArtistsAndAlbumsAndSongs(e)})}if(event.target.classList.contains("add__song--submit")){var v=document.querySelector(".add__song--album").value,A=document.querySelector(".add__song--title").value,b=document.querySelector(".add__song--link").value,S=document.querySelector(".add__song--duration").value;t.default.postRequest("/songs/addSong",{album:v,title:A,link:b,duration:S},function(e){d().innerHTML=n.default.renderArtistsAndAlbumsAndSongs(e)})}})}function l(){return document.querySelector("#header")}function d(){return document.querySelector("#app")}i(),o();
},{"./Utils/Events/event-actions":"c1WM","./Utils/API/api-actions":"kuUU","./Components/Artists":"NbHq","./Components/Albums":"a9Z7","./Components/Songs":"bss0","./Components/header":"2KtP"}]},{},["GFX4"], null)
//# sourceMappingURL=/app.b681ae38.js.map