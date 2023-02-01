package com.cmsJsf;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "rDao")
@SessionScoped
public class RestaurantDaoImp implements RestaurantDAO{

    private String localCode;
    private Integer restaurantId;

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

//    public void setRestaurantId(Integer restaurantId) {
//        this.restaurantId = restaurantId;
        
        

    public Integer searchByRestaurantDao(String restaurantName) {
        SessionFactory sf = SessionHelper.getConnection();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Restaurant.class);
        cr.add(Restrictions.eq("restaurantName", restaurantName));
        Projection projection = Projections.property("restaurantId"); 
        cr.setProjection(projection); 
        Integer rid = (Integer)cr.uniqueResult();
        System.out.println("method " +rid);
        return rid;
    }

    public void restaurantLocaleCodeChanged(ValueChangeEvent e){
    
    	String rname = e.getNewValue().toString();
        Integer rid = searchByRestaurantDao(rname);
        this.restaurantId = rid;
        this.localCode=rname;
        Object sessMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("restaurantId", this.restaurantId);

    }

    @Override
    public List<Restaurant> showRestaurants() {
        SessionFactory sf = SessionHelper.getConnection();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Restaurant.class);
        List<Restaurant> list = cr.list();
        return list;
    }

    @Override
    public List<String> showRestaurantNames() {
        SessionFactory sf = SessionHelper.getConnection();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Restaurant.class);
        Projection projection = Projections.distinct(Projections.property("restaurantName")); 
        cr.setProjection(projection); 
        List<String> list = cr.list();
        return list;
    }
}

