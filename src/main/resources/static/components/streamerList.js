import {renderStreamer} from "../pages/streamerPage.js";
import {getJsonFromAddress} from "../util/ajax.js";
import {clearElement} from "../util/util.js";
import {main} from "../pages/mainPage.js";

export async function renderStreamerList(streamerListObj) {
    const div = document.createElement('div')
    const h3 = document.createElement('h3')
    h3.innerText = "Список стримеров:"
    div.append(h3)
    streamerListObj.forEach(streamer => div.append(renderStreamerEl(streamer)))
    return div
}

function renderStreamerEl(streamer){
    const div = document.createElement('div')
    const button = document.createElement('button')
    button.innerText = streamer.pseudonym
    button.onclick = async() => getStreamer(streamer.id)
    div.append(button)
    return div
}

async function getStreamer(id) {
    clearElement(main)
    const streamer = await getJsonFromAddress('/streamer/' + id)
    main.append(renderStreamer(streamer))
}
