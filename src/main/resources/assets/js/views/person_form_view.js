window.PersonForm = Backbone.View.extend({
	template: _.template($("#form-template").html()),
	events: {
		"submit form": "savePerson"
	},
	
	savePerson: function(){
		var formParms = $('form :input');
		
		
	}
});