package wtc.carbon.carbonbackend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页返回结果对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T>{
    private List<T> records;//当前页数据集合
    private Long total;//总条数
}
