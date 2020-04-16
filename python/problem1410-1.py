class Solution:
    def entityParser(self, text: str) -> str:
        result = []
        idx = 0
        i = 0
        L = len(text)
        while i < L:
            add = False
            if text[i] == '&':
                if i + 6 < L:
                    if text[i + 1 : i + 7] == 'frasl;':
                        result.append('/')
                        add = True
                        i += 7
                        continue
                if i + 5 < L:
                    if text[i + 1 : i + 6] == 'quot;':
                        result.append('\"')
                        add = True
                        i += 6
                        continue
                    elif text[i + 1 : i + 6] == 'apos;':
                        result.append('\'')
                        add = True
                        i += 6
                        continue
                if i + 4 < L:
                    if text[i + 1 : i + 5] == 'amp;':
                        result.append('&')
                        add = True
                        i += 5
                        continue
                if i + 3 < L:
                    if text[i + 1 : i + 4] == 'gt;':
                        result.append('>')
                        add = True
                        i += 4
                        continue
                    elif text[i + 1 : i + 4] == 'lt;':
                        result.append('<')
                        add = True
                        i += 4
                        continue
            if not add:
                result.append(text[i])
                i += 1
        return ''.join(result)
