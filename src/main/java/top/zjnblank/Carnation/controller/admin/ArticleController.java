package top.zjnblank.Carnation.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.zjnblank.Carnation.dao.ArticleRepository;
import top.zjnblank.Carnation.entity.TbArticle;

import java.util.UUID;

@RestController("AdminArticleController")
@RequestMapping("/admin/article")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArticleController {
    private final ArticleRepository articleRepository;

    @GetMapping(value = "/publish")
    public ModelAndView publishView() {
        return new ModelAndView("/article/publish");
    }

    @PostMapping(value = "/publish")
    public ModelAndView publish(@RequestParam(value = "text") String content) {
        TbArticle article = new TbArticle();
        article.setContent(content);
        article.setTitle("");
        article.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        articleRepository.save(article);
        return new ModelAndView("/article/publish");
    }
}
