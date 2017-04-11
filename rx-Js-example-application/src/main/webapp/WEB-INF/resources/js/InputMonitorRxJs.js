$(document).ready(function () {
    Rx.Observable.fromEvent(
				document.getElementById("author-name"), 'keyup').
			throttleTime(10).
			map((e) => e.target.value).
			distinctUntilChanged().
			switchMap(function(e) {
				return Rx.Observable.forkJoin(
					[$.get("http://localhost:8080/application?author="+e), 
					$.get("http://localhost:8080/book?author="+e)]);
			}).
			reduce((applications, books) => applications.concat(books)).
			subscribe((e) => console.log(e));
});