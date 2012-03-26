window.PeopleView = Backbone.View.extend({
  initialize : function() {
    this.collection.on('add', this.addOne, this);
    this.collection.on('reset', this.addAll, this);

    tagName: "ol",

    render: function(){
        this.personForm.render();
    	this.addAll();
        return this;
    },

    addAll: function() {
        this.$el.empty();
        this.collection.forEach(this.addOne, this);
    },

    addOne: function(person){
        var personView = new PersonView({model: person});
        this.$el.append(personView.render().el);
    },
    
    savePerson: function(event) {
    	console.log("save person clicked-inside peopleview");
    	event.preventDefault();
    	var person = this.personForm.savePerson(event);
    	this.addOne(person);
    }
});
