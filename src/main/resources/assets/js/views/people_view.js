window.PeopleView = Backbone.View.extend({
  initialize : function() {
    this.collection.on('add', this.addOne, this);
    this.collection.on('reset', this.addAll, this);

    this.personForm = new PersonForm();
    this.personForm.on('submit', this.createNewPerson, this);
    this.personForm.render();
  },

  tagName : "ol",

  render : function() {
    this.addAll();
    this.personForm.render();
    return this;
  },

  addAll : function() {
    this.$el.empty();
    this.collection.forEach(this.addOne, this);
  },

  createNewPerson : function() {
    var person = this.savePerson();
    this.addOne(person);
  },
  
  addOne : function(person) {
    var personView = new PersonView({
      model : person
    });
    this.$el.append(personView.render().el);
  },
  
  removePerson : function(id) {
    thid.collection.destroy();
  },

  savePerson : function(event) {
    var person = this.personForm.savePerson(event);
    this.addOne(person);
  }
});
