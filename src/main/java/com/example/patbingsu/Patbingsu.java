package com.example.patbingsu;

import jakarta.persistence.*;

// 팥빙수 엔티티
@Entity
public class Patbingsu {

  // 기본 키 (ID 값 자동 생성)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 팥빙수 이름 (필수 입력)
  @Column(nullable = false)
  private String name;

  // 팥빙수 설명 (선택 입력)
  private String description;

  // 팥빙수 가격 (단위: 원)
  private int price;

  // 기본 생성자
  public Patbingsu() {
  }

  // Getter & Setter
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public int getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }
}
