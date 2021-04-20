package top.zjnblank.Carnation.controller.content;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.zjnblank.Carnation.dao.ArticleRepository;
import top.zjnblank.Carnation.entity.TbArticle;

@RestController
@RequestMapping("/content/article")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArticleController {

    private final ArticleRepository articleRepository;

    @GetMapping(value = "/")
    public ModelAndView index(@PageableDefault Pageable pageable) {
        Page<TbArticle> page = articleRepository.findAll(pageable);
        return new ModelAndView("/article/index", "items", page.getContent());
    }

    @GetMapping(value = "/detail/{id}")
    public ModelAndView showDetail(@PathVariable String id) {
        TbArticle article = articleRepository.findById(id).orElse(null);
        return new ModelAndView("/article/detail", "item", article);
    }
}
