package trip.advisor.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * A class to define travel inventory items.
 */
@Entity
@Table(name = "item", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "category"}))
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	//TODO: if ItemCateforyType used here, than it adds uniqueConstraint for this field ,which causes a problem trying to add data in this table.
    @Column(name = "category")
    private String category;

	@Column(name = "enough_for_km")
	private int enoughForKm;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "notes")
	private String notes;
	
	//TODO: use_from - number in km which says from how many km trip this item should be taken to backpack

	//FetchType.LAZY - retrieved from db only when needed
	//cascade = { CascadeType.PERSIST, CascadeType.MERGE } ensures that changes made to the seasons collection are propagated to the database when persisting or merging an Item.
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "items_seasons", // owning side
			joinColumns = { @JoinColumn(name = "item_id") }, inverseJoinColumns = {
					@JoinColumn(name = "classificator_id") })
	private Set<Classificator> seasons = new HashSet<>();

	public Item() {
		super();
	}

	public Item(String name, String category, int enoughForKm, Double weight, String notes) {
		super();
		this.name = name;
		this.category = category;
		this.enoughForKm = enoughForKm;
		this.weight = weight;
		this.notes = notes;
	}

	public void addSeason(Classificator clf) {
	    this.seasons.add(clf);
	    clf.getItems().add(this);
	  }
//	  
//	  public void removeSeason(long clfId) {
//	    Classificator clf = this.seasons.stream().filter(t -> t.getId() == clfId).findFirst().orElse(null);
//	    if (clf != null) {
//	      this.seasons.remove(clf);
//	      clf.getItems().remove(this);
//	    }
//	  }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getEnoughForKm() {
		return enoughForKm;
	}

	public void setEnoughForKm(int enoughForKm) {
		this.enoughForKm = enoughForKm;
	}
	
	

	public Set<Classificator> getSeasons() {
		return seasons;
	}

	public void setSeasons(Set<Classificator> seasons) {
		this.seasons = seasons;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", category=" + category + ", enoughForKm=" + enoughForKm
				+ ", weight=" + weight + ", notes=" + notes + "]";
	}

}
