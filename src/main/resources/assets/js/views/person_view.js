window.PersonView = Backbone.View.extend({
    template : _.template('<a id="del" name="#">X</a> <b><%= fullName %></b> the <%= jobTitle %>'),
    urlRoot: "/person",
    tagName : "li",
    events: {
        'change input': 'toggleStatus',
        'click #del': 'remove'
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
        this.model.destroy({wait: false});
    },

    toggleStatus: function() {
        this.model.toggleStatus();
    }
});
