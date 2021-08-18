package de.ckrae.petstore.store;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity(name = "OrderEntity")
@Schema(name = "Order")
public class Order {

	@Id
	@GeneratedValue
	@Schema(example = "10")
	private Long id;

	@Basic
	@Schema(example = "198772")
	private Long petId;

	@Basic
	@Schema(example = "7")
	private Integer quantity;

	@Temporal(TemporalType.DATE)
	private Date shipDate;

	@Enumerated
	@Schema(example = "approved")
	private Status status;

	@Basic
	private Boolean complete;

	public Order() {

	}

	public Order(Long petId, Integer quantity, Date shipDate, Status status, Boolean complete) {
		super();
		this.petId = petId;
		this.quantity = quantity;
		this.shipDate = shipDate;
		this.status = status;
		this.complete = complete;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the petId
	 */
	public Long getPetId() {
		return petId;
	}

	/**
	 * @param petId the petId to set
	 */
	public void setPetId(Long petId) {
		this.petId = petId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the shipDate
	 */
	public Date getShipDate() {
		return shipDate;
	}

	/**
	 * @param shipDate the shipDate to set
	 */
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the complete
	 */
	public Boolean getComplete() {
		return complete;
	}

	/**
	 * @param complete the complete to set
	 */
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(complete, id, petId, quantity, shipDate, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Order other = (Order) obj;
		return Objects.equals(complete, other.complete) && Objects.equals(id, other.id)
				&& Objects.equals(petId, other.petId) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(shipDate, other.shipDate) && status == other.status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", petId=" + petId + ", quantity=" + quantity + ", shipDate=" + shipDate
				+ ", status=" + status + ", complete=" + complete + "]";
	}

}
