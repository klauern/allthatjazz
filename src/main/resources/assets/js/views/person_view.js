window.PersonView = Backbone.View.extend({
	template : _.template('<b><%= fullName %></b> the <%= jobTitle %>'),
	
	tagName : "li",
	events: {
		'change input': 'toggleStatus'
	},
	
	initialize: function(){
		this.model.on('change', this.render, this);
		this.model.on('destroy hide', this.remove, this);
	},
	
	render: function(){
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	
	remove: function() {
		this.$el.remove();
	},
	
	toggleStatus: function() {
		this.model.toggleStatus();
	}
});