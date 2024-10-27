package org.esports.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nickname", length = 50, nullable = false)
    private String nickname;

    @Min(value = 12, message = "player must be older than 12!")
    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "teamID")
    private Team team;

    public Player() {
    }

    public Player(int id, String nickname, int age) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void showDetails() {
        System.out.println("Nickname: " + nickname);
        System.out.println("Age: " + age);
        if (team != null) {
            System.out.println("Team: " + team.getName());
        } else {
            System.out.println("No team assigned.");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }
}
