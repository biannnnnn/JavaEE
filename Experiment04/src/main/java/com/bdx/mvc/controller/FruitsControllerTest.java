package com.bdx.mvc.controller;

import com.bdx.mvc.model.Fruits;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FruitsControllerTest implements Controller {
    private FruitsService fruitsService = new FruitsService();

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当于request的setAttribute,在JSP页面中通过fruitsList获取数据
        modelAndView.addObject("fruitsList", fruitsList);
        // 指定视图
        modelAndView.setViewName("jsp/fruits/fruitsList.jsp");
        return modelAndView;
    }
}

// 模拟Service的内部类
class FruitsService {
    public List<Fruits> queryFruitsList() {
        List<Fruits> fruitsList = new ArrayList<>();

        Fruits apple = new Fruits();
        apple.setName("红富士苹果");
        apple.setPrice(2.3);
        apple.setProducing_area("山东");

        Fruits banana = new Fruits();
        banana.setName("香蕉");
        banana.setPrice(1.5);
        banana.setProducing_area("山东");

        fruitsList.add(apple);
        fruitsList.add(banana);
        return fruitsList;
    }
}
