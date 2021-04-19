package top.zjnblank.Carnation.controller.content;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.zjnblank.Carnation.dao.ArticleRepository;
import top.zjnblank.Carnation.entity.TbArticle;

import java.util.UUID;

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

    @GetMapping(value = "/publish")
    public ModelAndView showPublishArticle() {
        return new ModelAndView("/article/publish");
    }

    @PostMapping(value = "/publish")
    public ModelAndView publishArticle(@RequestParam(value = "text") String articleContent) {
        TbArticle article = new TbArticle();
        article.setContent(articleContent);
        article.setTitle("haha");
        article.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        articleRepository.save(article);
        return new ModelAndView("/article/publish");
    }
}
