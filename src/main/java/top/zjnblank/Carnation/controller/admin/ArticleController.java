package top.zjnblank.Carnation.controller.admin;

import cn.hutool.core.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.zjnblank.Carnation.dao.ArticleRepository;
import top.zjnblank.Carnation.entity.TbArticle;

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
    public void publishApi(@RequestParam(value = "text") String content,
                                   @RequestParam(value = "title") String title) {
        TbArticle article = new TbArticle();
        article.setContent(content);
        article.setTitle(title);
        article.setId(IdUtil.simpleUUID());
        articleRepository.save(article);
    }
}
