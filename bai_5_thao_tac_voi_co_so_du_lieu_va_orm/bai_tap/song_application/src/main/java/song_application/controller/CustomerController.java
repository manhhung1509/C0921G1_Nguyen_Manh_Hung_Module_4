package song_application.controller;

import song_application.model.Song;
import song_application.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("song")
public class CustomerController {

    @Autowired
    SongService songService;

    @GetMapping("")
    public ModelAndView showList(){
        List<Song> songList = songService.findAll();
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("songList",songList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song",new Song());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (Song song, RedirectAttributes redirectAttributes){
        songService.save(song);
        redirectAttributes.addFlashAttribute("success", "create song successfully!");
        return "redirect:/song";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable Long id){
        Song song = songService.finById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("song", song);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete (Song song, RedirectAttributes redirectAttributes){
        Long id = song.getId();
        songService.remove(id);
        redirectAttributes.addFlashAttribute("success", "delete song successfully!");
        return "redirect:/song";
    }

    @GetMapping("/{id}/update")
    public ModelAndView showUpdate(@PathVariable Long id){
        Song song = songService.finById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("song", song);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update (Song song, RedirectAttributes redirectAttributes){
        songService.save(song);
        redirectAttributes.addFlashAttribute("success", "delete song successfully!");
        return "redirect:/song";
    }
}
