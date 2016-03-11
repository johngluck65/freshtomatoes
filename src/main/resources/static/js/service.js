
(function(angular) {
  var HATEOAS_URL = './api/movies';
  var MovieFactory = function($http, SpringDataRestAdapter) {
    function Movie(movie) {
      return movie;
    }
    
    Movie.query = function(callback) {
      var deferred = $http.get(HATEOAS_URL);
      return SpringDataRestAdapter.process(deferred).then(function(data) {
        Movie.resources = data._resources("self");
        callback && callback(_.map(data._embeddedMovies, function(movie) {
          return new Movie(movie);
        }));
      });
    };
    
    Movie.resources = null;
    
    return Movie;
  };
  
  MovieFactory.$inject = ['$http', 'SpringDataRestAdapter'];
  angular.module("appname.services").factory("Movie", MovieFactory);
}(angular));
