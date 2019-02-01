package com.example.database.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.database.entity.OrderDetails;


@Repository
@Transactional
public class OrderDetailsRepository {
	@Autowired
	EntityManager em;
	
	public List<OrderDetails> getAll(){
		
		TypedQuery<OrderDetails> query = em.createQuery("from OrderDetails  ",OrderDetails.class);
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<OrderDetails> orderDetailss = query.getResultList();
		return orderDetailss;
		
		
	}
	public OrderDetails getOne(int id) {
		return em.find(OrderDetails.class, id);
		
	}
	public List<OrderDetails> getByOrderId(int id){
		TypedQuery<OrderDetails> query = em.createQuery("from OrderDetails ord where ord.ordersId=:id ",OrderDetails.class);
		query.setParameter("id", id);
		List<OrderDetails> lsOrd = query.getResultList();
		return lsOrd;
		
	}
	public void add(OrderDetails orderDetails)
	{
		em.merge(orderDetails);
	}
	public void  update(OrderDetails orderDetails) {
		em.persist(orderDetails);
	}
	public void delete(OrderDetails orderDetails) {
		em.remove(orderDetails);
		
	}
	public List<Object[]> getDetailObject()
	{
		List<Object[]> order = em.createQuery(
			    "select ord.unitPrice,ord.unitPrice,ord.quantity, o.address " +
			    "from OrderDetails ord " +
			    "Inner join Orders o ON ord.ordersId = o.orderId").getResultList();
		return order;

				
		
}
}