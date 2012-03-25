window.PeopleApp = new (Backbone.Router.extend({
    routes: {
        "": "index",
        "/person/:id": "show"
    },

    initialize: function() {
        this.people = new People();
        this.peopleView = new PeopleView({collection: this.people});
        this.peopleView.render();
    },

    index: function() {
    	$('#bb-people-form').html(this.peopleView.personForm.el);
        $('#people-list').html(this.peopleView.el);
        this.people.fetch();
    },

    start: function() {
        Backbone.history.start();
    },

    show: function(id) {
        this.people.focusOnPerson(id);
    }
}));
