$(document).ready(function () {
    Rx.Observable.fromEvent(
				document.getElementById("author-name"), 'keyup').
			throttleTime(10).
			map((e) => e.target.value).
			distinctUntilChanged().
			switchMap(
				(e) => Rx.Observable.fromPromise($.get("http://localhost:8080/application?author="+e)),
				(e) => Rx.Observable.fromPromise($.get("http://localhost:8080/book?author="+e)),
				(applications, books) => applications.concat(books)
			).
			subscribe((e) => console.log(e.promise));

});