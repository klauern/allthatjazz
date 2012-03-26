window.PersonView = Backbone.View.extend({
  template : _.template('<a id="del" name="#">X</a> <b><%= fullName %></b> the <%= jobTitle %>'),
  tagName : "li",
  events : {
//    'change input' : 'toggleStatus',
    'click #del' : 'remove'
  },

  render : function() {
    this.$el.html(this.template(this.model.toJSON()));
    return this;
  },

  remove : function() {
    this.$el.remove();
    this.model.destroy();
  }
});