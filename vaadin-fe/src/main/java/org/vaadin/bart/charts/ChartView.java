package org.vaadin.bart.charts;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.Route;

import org.vaadin.bart.GreetService;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ListSeries;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.vaadin.bart.MainView;


@Route
@CssImport(value = "./styles/chart-styles.css", themeFor = "vaadin-chart", include = "vaadin-chart-default-theme")
public class ChartView extends VerticalLayout {
    
    public ChartView() {

        RouterLink homeLink = new RouterLink("Hello", MainView.class);
        // RouterLink aboutLink = new RouterLink("About", AboutView.class);

        // Optionally, you can style the menu items
        homeLink.addClassName("menu-item");
        // aboutLink.addClassName("menu-item");

        add(homeLink);


        Chart chart = new Chart();
        Configuration configuration = chart.getConfiguration();
        configuration.setTitle("Sample Line Chart");
        
        ListSeries series = new ListSeries("Data", 1, 3, 2, 4, 5, 3, 6);
        configuration.addSeries(series);
        
        add(chart);
    }
}
