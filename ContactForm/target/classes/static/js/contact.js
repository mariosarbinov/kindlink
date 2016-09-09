angular.module('contact', [])
  .controller('submit', ['$scope', '$http', function($scope, $http) {
        $scope.submit = function() {
        
        if($scope.name && $scope.email && $scope.message){
        	var formDataAsJson = {email:$scope.email, name:$scope.name, message:$scope.message};
        	
  			$http.post("/contact-us", formDataAsJson, {
        		headers: { 'Content-Type': 'application/json; charset=UTF-8'},
    		}).success(function(responseData) {
       			console.log(responseData);
       			$('#sent').show();
   			});
   			
   		}else{
   			alert("Please fill all fields.");
   		}
    }
}]).controller('list', ['$scope', '$http', function($scope, $http) {
        $scope.list = function() {
  		$http.get("/contact-us").success(function(responseData) {
       		console.log(responseData);
   		});
    }
}]);