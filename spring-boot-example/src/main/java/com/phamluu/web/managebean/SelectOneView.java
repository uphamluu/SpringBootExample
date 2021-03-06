package com.phamluu.web.managebean;
 
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.phamluu.web.entity.Theme;
import com.phamluu.web.service.ThemeService;
 
@ManagedBean
public class SelectOneView {
     
    private String option;   
    private Theme theme; 
    private List<Theme> themes;
     
    @ManagedProperty("#{themeService}")
    private ThemeService service;
     
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
 
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
 
    public Theme getTheme() {
        return theme;
    }
 
    public void setTheme(Theme theme) {
        this.theme = theme;
    }
 
    public List<Theme> getThemes() {
        return themes;
    }
 
    public void setService(ThemeService service) {
        this.service = service;
    }
}