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
        // ����ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // �൱��request��setAttribute,��JSPҳ����ͨ��fruitsList��ȡ����
        modelAndView.addObject("fruitsList", fruitsList);
        // ָ����ͼ
        modelAndView.setViewName("jsp/fruits/fruitsList.jsp");
        return modelAndView;
    }
}

// ģ��Service���ڲ���
class FruitsService {
    public List<Fruits> queryFruitsList() {
        List<Fruits> fruitsList = new ArrayList<>();

        Fruits apple = new Fruits();
        apple.setName("�츻ʿƻ��");
        apple.setPrice(2.3);
        apple.setProducing_area("ɽ��");

        Fruits banana = new Fruits();
        banana.setName("�㽶");
        banana.setPrice(1.5);
        banana.setProducing_area("ɽ��");

        fruitsList.add(apple);
        fruitsList.add(banana);
        return fruitsList;
    }
}
