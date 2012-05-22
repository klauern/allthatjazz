window.PersonView = Backbone.View.extend({
  template : _.template('<a class="btn-mini btn-danger" id="del" href="" name="#">delete</a> <b><%= fullName %></b> the <%= jobTitle %>'),
  tagName : "li",
  events : {
    'click #del' : 'remove'
  },

  render : function() {
    this.$el.html(this.template(this.model.toJSON()));
    return this;
  },

  remove : function(event) {
    event.preventDefault();
    this.$el.remove();
    this.model.destroy();
  }
});