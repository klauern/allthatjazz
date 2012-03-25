window.PersonForm = Backbone.View.extend({
	template : _.template($("#form-template").html()),

	render : function() {
		this.$el.html(this.template());
	},

	savePerson : function(event) {
		event.preventDefault();
		var person = new Person({
			fullName : $('#create-person-f :input[name="fullName"]').val(),
			jobTitle : $('#create-person-f :input[name="jobTitle"]').val()
		});
		console.log("saving person");
		person.save();
		return person;
	}
});
