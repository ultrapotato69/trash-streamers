import {renderStreamerList} from "../components/streamerList.js";
import {renderStreamerForm} from "../components/newStreamerForm.js";
import {clearElement} from "../util/util.js";
import {getJsonFromAddress} from "../util/ajax.js";
import {renderNewVideoForm} from "../components/newVideoForm.js";

export const main = document.getElementById('main');

(async () => { await printFirstPage() })()

export async function printFirstPage(){
    clearElement(main)
    let streamerListObj = await getJsonFromAddress('/streamer/')
    const streamerList = await renderStreamerList(streamerListObj)
    main.append(streamerList)

    const newStreamerForm = renderStreamerForm()
    main.append(newStreamerForm)

    const newVideoForm = renderNewVideoForm(streamerListObj)
    main.append(newVideoForm)
}



