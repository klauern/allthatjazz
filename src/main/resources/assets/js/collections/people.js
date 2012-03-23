window.People = Backbone.Collection.extend({
	model : Person,
	
	url: "/people",
	
	initialize: function(){
		this.on('remove', this.hideModel, this);
	},
	
	hideModel: function(model) {
		model.trigger('hide');
	},
	
	focusOnPerson: function(id){
		var modelsToRemove = this.filter(function(person){
			return person.id != id;
		});
	}
});