import {getTextInput} from "./textInput.js";
import {postJson} from "../util/ajax.js";
import {printFirstPage} from "../pages/mainPage.js";


export function renderNewVideoForm(streamerListObj) {
    const div = document.createElement('div')
    const h3 = document.createElement('h3')
    h3.innerText = "Добавить новое видео:"
    div.append(h3)
    const videoFormElem = document.createElement('form')
    videoFormElem.id = 'videoForm'
    const youtubeUrl = getTextInput('youtubeUrlText', 'Youtube url: ', 75)
    videoFormElem.append(youtubeUrl)
    const b = document.createElement('b')
    b.innerText = 'Участники: '
    videoFormElem.append(b)
    videoFormElem.append(document.createElement('br'))
    for (let i = 0; i < streamerListObj.length; i++) {
        const label = document.createElement('label')
        label.innerText = streamerListObj[i].pseudonym
        const checkbox = document.createElement('input')
        checkbox.type = 'checkbox'
        checkbox.classList.add("sl-chb")
        checkbox.value = streamerListObj[i].id
        label.append(checkbox)
        label.append(document.createElement('br'))
        videoFormElem.append(label)
    }
    const videoSubmit = document.createElement('input')
    videoSubmit.type = 'submit'
    videoSubmit.value = 'Добавить'
    videoFormElem.append(videoSubmit)

    videoFormElem.onsubmit = videoFormHandler()
    div.append(videoFormElem)
    return div
}


function videoFormHandler() {
    return async (e) => {
        e.preventDefault();
        const checkboxes = document.querySelectorAll('.sl-chb:checked')
        const url = document.getElementById('youtubeUrlText')
        let arrCheck = Array.from(checkboxes).map(checkbox => checkbox.value);
        let videoDto = {
            youtube_url: url.value,
            ids:arrCheck
        }
        await postJson(videoDto, 'video')
        await printFirstPage()
    };
}

