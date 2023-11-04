$(function() {
	"use strict";
	new PerfectScrollbar(".header-message-list"), new PerfectScrollbar(".header-notifications-list"), $(".mobile-search-icon").on("click", function() {
		$(".search-bar").addClass("full-search-bar")
	}), $(".search-close").on("click", function() {
		$(".search-bar").removeClass("full-search-bar")
	}), $(".mobile-toggle-menu").on("click", function() {
		$(".wrapper").addClass("toggled")
	}), $(".toggle-icon").click(function() {
		$(".wrapper").hasClass("toggled") ? ($(".wrapper").removeClass("toggled"), $(".sidebar-wrapper").unbind("hover")) : ($(".wrapper").addClass("toggled"), $(".sidebar-wrapper").hover(function() {
			$(".wrapper").addClass("sidebar-hovered")
		}, function() {
			$(".wrapper").removeClass("sidebar-hovered")
		}))
	}), $(document).ready(function() {
		$(window).on("scroll", function() {
			$(this).scrollTop() > 300 ? $(".back-to-top").fadeIn() : $(".back-to-top").fadeOut()
		}), $(".back-to-top").on("click", function() {
			return $("html, body").animate({
				scrollTop: 0
			}, 600), !1
		})
	}),

	$(document).ready(function () {
        $(window).on("scroll", function () {
            if ($(this).scrollTop() > 60) {
                $('.topbar').addClass('bg-dark');
            } else {
                $('.topbar').removeClass('bg-dark');
            }
        });
        $('.back-to-top').on("click", function () {
            $("html, body").animate({
                scrollTop: 0
            }, 600);
            return false;
        });
    });


	$(function() {
		for (var e = window.location, o = $(".metismenu li a").filter(function() {
				return this.href == e
			}).addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active")
	}), $(function() {
		$("#menu").metisMenu()
	}), $(".chat-toggle-btn").on("click", function() {
		$(".chat-wrapper").toggleClass("chat-toggled")
	}), $(".chat-toggle-btn-mobile").on("click", function() {
		$(".chat-wrapper").removeClass("chat-toggled")
	}), $(".email-toggle-btn").on("click", function() {
		$(".email-wrapper").toggleClass("email-toggled")
	}), $(".email-toggle-btn-mobile").on("click", function() {
		$(".email-wrapper").removeClass("email-toggled")
	}), $(".compose-mail-btn").on("click", function() {
		$(".compose-mail-popup").show()
	}), $(".compose-mail-close").on("click", function() {
		$(".compose-mail-popup").hide()
	}),


	$('#theme1').click(theme1);

    function theme1() {
      $('body').attr('class', 'bg-theme bg-theme1');
    }
});


$(document).ready(function()
{
    $('#open-home-dashboard-page-sidebar-item').on("click", function ()
    {
        pageLoader.loadPage("homeDashboard");
    });
});


var common =
{
    convertJavaListToArray : function(javaList)
    {
        const array = [];

        for(var i = 0; i < javaList.size(); i++)
        {
            array[i] = javaList.get(i)
        }

        return array;
    }
}


var oriongateCharts =
{
    buildDonutChartWith2Elements : function(chartID, valueArray, chartLabels)
    {
        var options =
        {
            series: valueArray,
            colors: ["#198fed", "#32ab13"],
            labels: chartLabels,
            plotOptions:
            {
                pie:
                {
                    donut:
                    {
                        labels:
                        {
                            show: true,
                            total:
                            {
                                showAlways: true,
                                show: true
                            }
                        }
                    }
                }
            },
            chart:
            {
                foreColor: 'rgba(255, 255, 255, 0.65)',
                //height: 380,
                type: 'donut',
            },
            responsive:
            [{
                breakpoint: 480,
                options:
                {
                    chart:
                    {
                        height: 360
                    },
                    legend:
                    {
                        position: 'bottom'
                    }
                }
            }]
        };

        var chart = new ApexCharts(document.querySelector(chartID), options);
        chart.render();
    }
}