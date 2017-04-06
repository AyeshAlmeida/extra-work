$(document).ready(function () {
    Rx.Observable.fromEvent(document.getElementById('author-name'), 'keyup').
    throttleTime(60).
    distinctUntilChanged().switchMap(function(e){
        return Rx.Observable.fromPromise($.get("http://localhost:8080?author="+e.target.value);
    }).
    subscribe(e => console.log(e.target.value));
});