window.PeopleView = Backbone.View.extend({
  initialize : function() {
    this.collection.on('add', this.addOne, this);
    this.collection.on('reset', this.addAll, this);

    this.personForm = new PersonForm();
    this.personForm.on('submit', this.savePerson, this);
    this.personForm.render();
    // this.personForm.on('add', 'render');
  },

  tagName : "ol",

  render : function() {
    this.personForm.render();
    this.addAll();
    return this;
  },

  addAll : function() {
    this.$el.empty();
    this.collection.forEach(this.addOne, this);
  },

  addOne : function(person) {
    var personView = new PersonView({
      model : person
    });
    this.$el.append(personView.render().el);
  },

  savePerson : function(event) {
    // event.preventDefault();
    console.log("save person clicked--inside peopleview");
    var person = this.personForm.savePerson(event);
    this.addOne(person);
  }
});
