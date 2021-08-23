package de.ckrae.petstore.pet;

import java.net.URL;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(name = "Pet")
public class Pet {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Category category;

	@Basic
	@Schema(required = true, example = "doggie")
	private String name;

	@ElementCollection
	@Schema(required = true)
	private Collection<URL> photoUrls;

	@ManyToMany
	private Collection<Tag> tags;

	@Enumerated
	@Schema(description = "pet status in the store")
	private Status status;

	public Pet() {
		super();
	}

	public Pet(Long id, Category category, String name, Collection<URL> photoUrls, Collection<Tag> tags,
			Status status) {
		this(category, name, photoUrls, tags, status);
		this.id = id;
	}

	public Pet(Category category, String name, Collection<URL> photoUrls, Collection<Tag> tags, Status status) {
		super();
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
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
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the photoUrls
	 */
	public Collection<URL> getPhotoUrls() {
		return photoUrls;
	}

	/**
	 * @param photoUrls the photoUrls to set
	 */
	public void setPhotoUrls(Collection<URL> photoUrls) {
		this.photoUrls = photoUrls;
	}

	/**
	 * @return the tags
	 */
	public Collection<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Collection<Tag> tags) {
		this.tags = tags;
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

	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, photoUrls, status, tags);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Pet other = (Pet) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(photoUrls, other.photoUrls)
				&& status == other.status && Objects.equals(tags, other.tags);
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", category=" + category + ", name=" + name + ", photoUrls=" + photoUrls + ", tags="
				+ tags + ", status=" + status + "]";
	}

}
