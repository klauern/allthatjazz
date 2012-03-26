window.PersonForm = Backbone.View.extend({
  template : _.template($("#form-template").html()),
  initialize : function() {
  },

  events : {
    'submit #create-person-f' : 'triggerSave'
  },
  
  render : function() {
    this.$el.html(this.template());
  },
  
  triggerSave : function(event) {
    event.preventDefault();
    console.log("triggered event in person form");
    this.trigger('submit');
  },

  savePerson : function(event) {
    console.log("submit clicked");
    var person = new Person({
      fullName : $('#create-person-f :input[name="fullName"]').val(),
      jobTitle : $('#create-person-f :input[name="jobTitle"]').val()
    });
    console.log("saving person");
    person.save();
    $('form')[ 0 ].reset();
    return person;
  }
});
