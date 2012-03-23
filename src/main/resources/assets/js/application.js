////(function($) {
////	window.AppView = Backbone.View.extend({
////		el : $("people"),
////		initialize : function() {
////			
////		}
////		events : {
////			"click #add-friend" : "showPrompt"
////		},
////		showPrompt : function() {
////			var friend_name = prompt("Who is your friend");
////		}
////	});
////	var appview = new AppView;
////})(jQuery);
//
//var Person = Backbone.Model.extend({
//	urlRoot: "/person"
//});
//
//var PersonView = Backbone.View.extend({
//	tagName : "li",
//	className: "person",
//	initialize: function(){
//		this.model.on('change', this.render, this);
//		this.model.on('destroy', this.remove, this);
//		this.model.on('hide', this.remove, this);
//	},
//	render: function() {
//		this.$el.html(this.template(this.model.toJSON()));
//	},
//	remove: function() {
//		this.$el.remove();
//	},
//	template : _.template('<h3><%= fullName %></h3> - <span><%= jobTitle %></span>')
//});
//
//var PeopleList = Backbone.Collection.extend({
//	url: "/people",
//	model: Person,
//	initialize: function() {
//		this.on('remove', this.hideModel);
//	},
//	hideModel: function(model) {
//		model.trigger('hide');
//	}
//});
//
//var PeopleListView = Backbone.View.extend({	
//	initialize: function() {
//		this.collection.on('add', this.addOne, this);
//		this.collection.on('reset', this.addAll, this);
//	},
//	addOne: function(person) {
//		var personView = new PersonView({model: person});
//		this.$el.append(personView.render().el);
//	},
//	addAll: function(person) {
//		this.collection.forEach(this.addOne, this);
//	},
//	render: function() {
//		this.addAll();
//	}
//});
//
//var PeopleApp = new (Backbone.Router.extend({
//	routes: { "" : "index", 
//			"person/:id" : "show"},
//	initialize : function() {
//		this.peopleList = new PeopleList();
//		this.peopleListView = new PeopleListView({
//			collection: this.peopleList
//		});
//		$('#people').append(this.peopleListView.el);
//	},
//	start: function() {
//		Backbone.history.start({pushState: true});
//	},
//	index: function() {
//		this.peopleList.fetch();
//	},
//	show: function(id) {
//		console.log(id);
//	}
//}));

$(function(){ PeopleApp.start() });