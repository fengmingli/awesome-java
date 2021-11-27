package com.lifengming.client;




import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author lifengming
 * @date 2020.06.28
 */

public class TicketDTO implements Serializable {
    private static final long serialVersionUID = -888L;

    @NotNull(message = "name不能为null")
    private String name;

    @NotNull(message = "not null")
    @Min(message = "最小为10", value =10 )
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
