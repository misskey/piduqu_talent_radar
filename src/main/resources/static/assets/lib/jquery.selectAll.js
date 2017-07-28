
;(function (factory) {
    if (typeof define === "function" && define.amd) {
        // AMD模式
        define([ "jquery" ], factory);
    } else {
        // 全局模式
        factory(jQuery);
    }
}(function ($) {

    var allSelect = function(option ,element){
        this.$el = $( element );
        this.option = $.extend( {} , defaults , option);
        this.value = [];
        this.price = [];
        this._init();
    };

    var defaults = {
        parentClass : 'select_parent',                  //包含整个子复选框的节点class
        childClass : 'select_child',                    //所有子复选框共有的class
        attr : 'value',                                 //区别每一个子复选框的特有属性
        attrPrice : '_price',                                 //区别每一个子复选框的特有属性
        selectLengthClass : 'select_length',            //显示选中条数的class
        onSelected : function(){return false;}          //子复选框选中的事件
    };

    allSelect.prototype = {

        _init : function(){
            var me = this;
            var option = this.option;
            var $parent = $('.' + option.parentClass );
            if($parent.length == 0){
                $parent = $(document);
            }
            this.$children = $parent.find('.'+ option.childClass + '[' + option.attr + ']' );
            this.checkLength = 0;
            this.$children.on('click',function(){
                var _id = $(this).attr( option.attr );
                var id = me.option.onSelected( $(this) , _id );
                id = id === false ? _id : id ;
       /*         var _price = $(this).attr(option.attrPrice);*/
             /*   var price = me.option.onSelected($(this),_price);*/

             /*   price = price === false ? _price : price ;*/
                if(!$(this).hasClass('checked')){
                    me.appendValue(id);
                  /*  me.appendPrice(price);*/
                }else{
                    me.removeValue(id) ;
            /*        me.removePrice(price);*/
                }
            /*    !$(this).hasClass('checked') ? me.appendValue(id) : me.removeValue(id);*/
            /*    $(this).toggleClass("checked");*/
                /*$('.'+ option.selectLengthClass).text(me.value.length);
                $(".J_all_pay").attr('payid',me.value);*/
            });
            this.$el.unbind('click');
            this.$el.bind('click',function(){
                if(!$(this).hasClass('checked')){
                    me.$children.each(function(){
                        var _id = $(this).attr(option.attr);

                        var id = me.option.onSelected($(this),_id);
                        id = id === false ? _id : id ;
                        var _price = $(this).attr(option.attrPrice);
                        var price = me.option.onSelected($(this),_price);

                        price = price === false ? _price : price ;
                        if(!$(this).hasClass('checked')){
                            me.appendValue(id);
                            me.appendPrice(price);
                            $(this).addClass('checked');
                            $(this).parents('.pos_item_Detail').addClass('checkedBg')
                        }
                    });


                }else{
                    me.$children.each(function(){
                        var _price = $(this).attr(option.attrPrice);
                        var price = me.option.onSelected($(this),_price);

                        price = price === false ? _price : price ;
                        var _id = $(this).attr(option.attr);
                        var id = me.option.onSelected($(this),_id);
                        id = id === false ? _id : id ;
                        if($(this).hasClass('checked')){
                            me.removeValue(id);
                            me.removePrice(price);
                            $(this).removeClass('checked');
                            $(this).parents('.pos_item_Detail').removeClass('checkedBg');
                        }
                    });
                }
               /* !$(this).hasClass('checked') ? (function(){



                })() : (function(){


                })() ;*/

                $(this).toggleClass("checked");
                $(this).parents('.pos_item_Detail').toggleClass('checkedBg')
           /*     $('.'+ option.selectLengthClass).text(me.value.length);
                $(".J_all_pay").attr('payid',me.value);*/

            });
            //console.log(this.value, this);
            $.each(this.value,function(index,val){
                $.each(me.$children,function(){
                    var _id = $(this).attr(option.attr);
                    var id = me.option.onSelected($(this),_id);
                    id = id === false ? _id : id ;
                    if(isObjectValueEqual( id, val )){
                      /*  $(this).attr('checked','checked');*/
                        $(this).addClass('checked');
                        $(this).parents('.pos_item_Detail').addClass('checkedBg')
                        me.checkLength ++;
                        return false;
                    }
                })
            });
            if(this.checkLength == this.$children.length && this.$children.length != 0){
                this.$el.addClass('checked');
                this.$el.parents('.pos_item_Detail').addClass('checkedBg')
            }
            else{
                this.$el.removeClass('checked');
                this.$el.parents('.pos_item_Detail').removeClass('checkedBg');
            }
        },
        appendPrice:function(price){
            this.price.push(parseFloat(price));
            var sum =0;
            if(this.price.length == this.$children.length){
                for(var i=0;i<this.price.length;i++){
                    sum += this.price[i];
                }
                $(".pay-sum").text(sum);
            }else{
                for(var i=0;i<this.price.length;i++){
                    sum += this.price[i];
                }
                $(".pay-sum").text(sum);
            }

        },
        removePrice:function(price){
            var me = this;
            var sum =0;
            $.each(this.price,function(index,val){
                if(val == price){
                    me.price.splice(index,1);
                    return false;
                }
            });
            if(me.price.length == 0){
                $(".pay-sum").text('0.00');
            }else{
                for(var i=0;i<me.price.length;i++){
                    sum += me.price[i];
                }
                $(".pay-sum").text(sum);
            }

        },
        appendValue : function(id){
            this.value.push(id);
            this.checkLength ++;
            if(this.checkLength == this.$children.length){
                this.$el.toggleClass('checked');
            }
        },
        removeValue : function(id){
            var me = this;
            $.each(this.value,function(index,val){
                if(isObjectValueEqual( id, val )){
                    me.value.splice(index,1);
                    return false;
                }
            });
            this.checkLength --;
            this.$el.removeClass('checked');
        },
        getValue : function(){
            return this.value.length == 0 ? null : this.value;
        },
        destroy : function(){
            //debugger;
            $.data (this.$el.get(0) , 'allSelect' ,null);
            $('.'+ this.option.selectLengthClass).text(0);
            return true;
        }
    };

    function isObjectValueEqual(a, b) {
        if(typeof a == 'object' && typeof b == 'object'){
            // Of course, we can do it use for in
            // Create arrays of property names
            var aProps = Object.getOwnPropertyNames(a);
            var bProps = Object.getOwnPropertyNames(b);

            // If number of properties is different,
            // objects are not equivalent
            if (aProps.length != bProps.length) {
                return false;
            }

            for (var i = 0; i < aProps.length; i++) {
                var propName = aProps[i];

                // If values of same property are not equal,
                // objects are not equivalent
                if (a[propName] !== b[propName]) {
                    return false;
                }
            }

            // If we made it this far, objects
            // are considered equivalent
            return true;
        }
        else{
            return a == b;
        }

    }

    $.fn.allSelect = function(options , value){
        if(typeof options === 'string'){
            //var result = [];
            //this.each(function(){
            //
            //});
            var result = null;

            var data = $.data( $(this).get(0) , 'allSelect' );

            if(data){
                var args = Array.prototype.slice.call(arguments , 1);
                if(value != undefined) { args.push(value); }
                //result.push(data[ options].apply( data , args ));
                result = data[ options].apply( data , args );
            }

            //else{
            //    result.push(undefined);
            //}
            return result;
        }
        else if(typeof options === 'object' || options === undefined){
            return this.each(function(){
                var data = $.data( $(this).get(0) , 'allSelect' );
                data ? data._init( options ) : data = $.data( this , 'allSelect' , new allSelect(options , this) );
            });

        }

    };

}));