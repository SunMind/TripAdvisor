//OTHER OPTION???

//package trip.advisor.model;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "season")
//public class Season {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//
//	@Column(name = "code")
//	private String code;
//
//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "seasons")
//	@JsonIgnore
//	private Set<Item> items = new HashSet<>();
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public Set<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(Set<Item> items) {
//		this.items = items;
//	}
//
//}
