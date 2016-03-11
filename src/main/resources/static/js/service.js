
(function(angular) {
  var HATEOAS_URL = './api/movies';
  var MovieFactory = function($http, SpringDataRestAdapter) {
    function Movie(movie) {
      
      if (movie._resources) {
        movie.resources = movie._resources("self", {}, {
          update: {
            method: 'PUT'
          }
        });
        movie.save = function(callback) {
          movie.resources.update(movie, function() {
            callback && callback(movie);
          });
        };
        
        movie.remove = function(callback) {
          movie.resources.remove(function() {
            callback && callback(movie);
          });
        };
      } else {
        movie.save = function(callback) {
          Movie.resources.save(movie, function(movie, headers) {
            var deferred = $http.get(headers().location);
            return SpringDataRestAdapter.process(deferred).then(function(newMovie) {
              callback && callback(new Movie(newMovie));
            });
          });
        };
      }

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
  angular.module("myApp.services").factory("Movie", MovieFactory);
}(angular));
