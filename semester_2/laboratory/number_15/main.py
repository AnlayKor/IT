from fastapi import FastAPI
import pyjokes
import wikipedia
from pydantic import BaseModel


wikipedia.set_lang("ru")


app = FastAPI()


@app.get("/")
def joke():
    return pyjokes.get_joke()


@app.get("/{search}")
def wikipedia_search(search: str):
    return wikipedia.summary(search)


@app.get("/multi/{request}")
def multi_wikipedia_search(request: str, wiki_number: int):
    titles = wikipedia.search(request, results=wiki_number)
    result = ''
    for i in titles:
        result += wikipedia.summary(i) + (' ')
    return result


class Wiki(BaseModel):
    search: str
    wiki: str


class WikiInput(BaseModel):
    search: str


@app.post("/", response_model=Wiki)
def create_joke(wiki_input: WikiInput):
    """Создание краткого содержания статьи"""
    return Wiki(search=wiki_input.search, wiki=wikipedia.summary(wiki_input.search))


#uvicorn main:app --reload

